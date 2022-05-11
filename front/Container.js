import React from 'react'
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs'
import 'react-tabs/style/react-tabs.css'

const REST_API_ITEMS = 'http://192.168.26.170:8181/api/items'
const REST_API_USERS = 'http://192.168.26.170:8181/api/users'

class Container extends React.Component {

    state = {
		items: [],
		currentItem: null,
		creator: '',
		newCode: 0,
		newDescription: '',
		newPrice: 0,
		modifyDescription: '',
		modifyState: null,
		modifyPrice: 0,
		modifyCreationDate: null,
		modifyCreator: '',
		modifyFieldsFlag: false,
		updateCreatorFlag: true,
	}

    componentDidMount(){
		fetch(REST_API_ITEMS)
		.then(resp => resp.json())
		.then(items => {
		  this.setState({
			items: items
		  })
		})
	}
	
	createNewItem = (event) => {
		
		event.preventDefault()
		
		fetch(REST_API_ITEMS, {
			method: "POST",
			headers: {
				'Content-Type': 'application/json',
				Accept: 'application/json'
			},
			body: JSON.stringify({
				itemCode: this.state.newCode,
				description: this.state.newDescription,
				price: this.state.newPrice,
				state: 'ACTIVE',
				creationDate: new Date()
			})
		})
		.then(resp => resp.json())
		.then(newItem => {
			
			fetch(REST_API_USERS, {
				method: "POST",
				headers: {
					'Content-Type': 'application/json',
					Accept: 'application/json'
				},
				body: JSON.stringify({
					username: this.props.loginuser,
					item_id: newItem.itemid
				})
			})
			
			this.setState({
				items: [...this.state.items, newItem]
			})
		})

	}
	
	
	modifyItem = (event) => {
		
		event.preventDefault()

		fetch(REST_API_ITEMS + '/' + this.state.currentItem.itemid, {
			method: "PUT",
			headers: {
				'Content-Type': 'application/json',
				Accept: 'application/json'
			},
			body: JSON.stringify({
				itemid: this.state.currentItem.itemid,
				description: this.state.modifyDescription,
				price: this.state.modifyPrice,
				state: this.state.modifyState,
				creationDate: this.state.modifyCreationDate
			})
		})
		.then(resp => resp.json())

		this.handleModifyFields(false)
		

	}
	
	
	handleChangeNewCode = (event) => {
		event.persist()
		this.setState({
			newCode: event.target.value
		})
	}
	
	handleChangeNewDescription = (event) => {
		event.persist()
		this.setState({
			newDescription: event.target.value
		})
	}
	
	handleChangeNewPrice = (event) => {
		event.persist()
		this.setState({
			newPrice: event.target.value
		})
	}
	
	handleChangeDescription = (event) => {
		event.persist()
		this.setState({
			modifyDescription: event.target.value
		})
	}
	
	handleChangeState = (event) => {
		event.persist()
		this.setState({
			modifyState: event.target.value
		})
	}
	
	handleChangePrice = (event) => {
		event.persist()
		this.setState({
			modifyPrice: event.target.value
		})
	}
	
	handleChangeCreationDate = (event) => {
		event.persist()
		this.setState({
			modifyCreationDate: event.target.value
		})
	}
	
	handleChangeCreator = (event) => {
		event.persist()
		this.setState({
			modifyCreator: event.target.value
		})
	}
	
	handleModifyFields = (flag) => {
		
		if(flag){
			this.setState({
				modifyFieldsFlag: true
			})
		}else{
			this.setState({
				modifyFieldsFlag: false
			})
		}
			
	}
	
	handleSuppliersFlag = (flag) => {
		
		if(flag){
			this.setState({
				updateSuppliersFlag: true
			})
		}else{
			this.setState({
				updateSuppliersFlag: false
			})
		}
			
	}
	
	selectCurrentItem = (code) => {
		
		this.state.items.map(item => {
			if (item.itemCode === code){
				this.setState({
					currentItem: item,
					modifyDescription: item.description,
					modifyState: item.state,
					modifyPrice: item.price,
					modifyCreationDate: item.creationDate,
					modifyCreator: '',
					updateCreatorFlag: true
			    })
			} 
		})
	
	
	}
	
	updateCreator = () => {
		
		fetch(REST_API_ITEMS + '/creator' + this.state.currentItem.itemid, {
			method: "GET",
			headers: {
				'Content-Type': 'application/json',
				Accept: 'application/json'
			}
		})
		.then(resp => resp.text())
		.then(username => {
		  this.setState({
			creator: username,
			updateCreatorFlag: false
		  })
		})
		
	}
	

	render (){
	
		let description,state,price,creationDate,creator,suppliers,priceReductions
		
		if(this.state.currentItem){
			description = this.state.currentItem.description
			state = this.state.currentItem.state
			price = this.state.currentItem.price
			creationDate = this.state.currentItem.creationDate
			if(this.state.updateCreatorFlag) {
				this.updateCreator() 
			}
			creator = this.state.creator
			suppliers = 
				this.state.currentItem.suppliers.map(supplier => (
					<p>{supplier.name}</p>
				))
			priceReductions = 
			this.state.currentItem.priceReductions.map(priceReduction => (
					<p>{priceReduction.reducedPrice}</p>
				))
			
		}else{
			description = ""
			state = ""
			price = ""
			creationDate = ""
			creator = ""
			suppliers = ""
			priceReductions = ""
		}
		
		let modifyFields1, modifyFields2
		if(this.state.modifyFieldsFlag){
			
			modifyFields1 = 
				<Tabs>
					<p><TabList>
						<Tab>Description</Tab>
						<Tab>State</Tab>
						<Tab>Price</Tab>
						<Tab>Creation date</Tab>
						<Tab>Creator</Tab>
						<Tab>Suppliers</Tab>
						<Tab>priceReductions</Tab>
					</TabList></p>
					
					<p><form onSubmit={this.modifyItem}>
						<TabPanel><textarea value={this.state.modifyDescription} onChange={this.handleChangeDescription}>{description}</textarea></TabPanel>
						<TabPanel><textarea value={this.state.modifyState} onChange={this.handleChangeState}>{state}</textarea></TabPanel>
						<TabPanel><textarea value={this.state.modifyPrice} onChange={this.handleChangePrice}>{price}</textarea></TabPanel>
						<TabPanel><textarea value={this.state.modifyCreationDate} onChange={this.handleChangeCreationDate}>{creationDate}</textarea></TabPanel>
						<TabPanel><textarea value={this.state.modifyCreator} onChange={this.handleChangeCreator}>{creator}</textarea></TabPanel>						
					<input type="submit" value="Save" />
					</form></p>
					
					<button className="little-button" onClick={() => this.handleModifyFields(false)}>Cancel</button>
				
				</Tabs>
				
			modifyFields2 = ""
			
		}else{
			
			modifyFields1 = ""
				
			modifyFields2 = 
				<Tabs>
					<p><TabList>
						<Tab>Description</Tab>
						<Tab>State</Tab>
						<Tab>Price</Tab>
						<Tab>Creation date</Tab>
						<Tab>Creator</Tab>
						<Tab>Suppliers</Tab>
						<Tab>priceReductions</Tab>
					</TabList></p>
					
					<p><TabPanel>{description}</TabPanel>
					<TabPanel>{state}</TabPanel>
					<TabPanel>{price}</TabPanel>
					<TabPanel>{creationDate}</TabPanel>
					<TabPanel>{creator}</TabPanel>
					<TabPanel>{suppliers}</TabPanel>
					<TabPanel>{priceReductions}</TabPanel></p>
					
					<button className="little-button" onClick={() => this.handleModifyFields(true)}>Modify</button>
				</Tabs>
				
		}
		
		
        return (
		
			<div className="main-container">
			
				<form className = "session">Username: {this.props.loginuser}</form>
			
				<h1>ITEMS</h1>
				
				<div className="item-list">
					{this.state.items.map(item => (
						item.state === 'ACTIVE' && <button className="item-button" onClick={() => this.selectCurrentItem(item.itemCode)}> Item {item.itemCode}</button>
					))}
				</div>
				
				<div className="item-add">
					<form  onSubmit={this.createNewItem} className="new-item-form">
						<h3>CREATE ITEM</h3>
						<p>Item code: <input className="new-item-input" type="number" value={this.state.inputCode} onChange={this.handleChangeNewCode}/></p>
						<p>Description: <input className="new-item-input" type="text" value={this.state.inputDescription} onChange={this.handleChangeNewDescription}/></p>
						<p>Price: <input className="new-item-input" type="number" value={this.state.inputPrice} onChange={this.handleChangeNewPrice}/></p>
						<input className="new-item-input" type="submit" value="Create" />
					</form>
				</div>
				
				
				<div className="item-information">
				
					{modifyFields1}
					{modifyFields2}
					
				</div>
				
				
			</div>
			
        )
    }
}

export default Container