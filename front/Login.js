import React from 'react'
import Container from './Container'

const REST_API_USERS = 'http://192.168.26.170:8181/api/users'
		
		
class Login extends React.Component {
	
	state = {
		users: [],
		isLogged: false,
		newUsername: '',
		newPassword: '',
		loginUserId: null
	}

	componentDidMount(){
		fetch(REST_API_USERS)
		.then(resp => resp.json())
		.then(users => {
			this.setState({
				users: users
			})
		})
	}	

	handleSubmit = () => {
			
		
		(this.state.users.find((user) => {
			if((user.username === this.state.newUsername) && (user.password === this.state.newPassword)){
				this.setState({
					isLogged: true,
					loginUserId: user.userid 
				})
			}
		}))
		
	}
	
	handleChangeNewUsername = (event) => {
		event.persist()
		this.setState({
			newUsername: event.target.value
		})
	}
	
	handleChangeNewPassword = (event) => {
		event.persist()
		this.setState({
			newPassword: event.target.value
		})
	}
	
	
	
	render (){
		 
		let renderLogin =
			<form className = "login-wrapper" onSubmit={this.handleSubmit}>
				<p><label>
					<p>Username</p>
					<input type="text" value={this.state.newUsername} onChange={this.handleChangeNewUsername}/>
				</label></p>
				<p><label>
					<p>Password</p>
					<input input type="password" value={this.state.newPassword} onChange={this.handleChangeNewPassword} />
				</label></p>
				<div>
					<button type="submit">Login</button>
				</div>
			</form>
		
		return (
				
			this.state.isLogged ? <Container loginuser={this.state.newUsername} loginUserId={this.state.loginUserId} /> : renderLogin
		)
	}
}

export default Login