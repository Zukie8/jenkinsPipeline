package com.revature.models;

/**
 * 
 * @author nozuk
 * This is an in-class exercise about servlets 09/04/2018
 * Create a new application which includes servlets and is packaged as a war
 * Create a servlet which performing a get request to will take you to a simple login page with an input field for username and password
 * Define doPost method which processes the post request sent when the login form is submitted
 * Check username and password (these can be hardcoded values) and have a user be brought to a page indicating that the username and/or password was incorrect if they are not correct, otherwise they should be brought to a successful login page

// small change
 */
public class Users {

	private String username;
	private String password;
	/**
	 * 
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param username
	 * @param password
	 */
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}

}
