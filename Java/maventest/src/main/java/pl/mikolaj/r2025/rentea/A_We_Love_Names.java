package pl.mikolaj.r2025.rentea;

import java.util.Date;
import java.util.List;

class UserFacade {
	private UserRepo userRepo;
	private UserMapper mapper;

	public List<UserDto> getAllUsers() {
		return userRepo.findAll().stream()
				.map(mapper::toDto)
				.toList();
	}
}

class UserMapper {
	public UserDto toDto(User user) {
		UserDto dto = new UserDto(user);
		dto.setUserName(user.getUserName());
		dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
		dto.setActive(user.getDeactivationDate() == null);
		return dto;
	}
}

class UserDto {
	private String userName;
	private String fullName;
	private boolean active;

	public UserDto(User user) {
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

interface UserRepo {
	List<User> findAll();
}

class User {
	private String userName;
	private String firstName;
	private String lastName;
	private Date deactivationDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}
};
