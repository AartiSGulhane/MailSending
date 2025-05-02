package com.mailsending.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mailsending.exception.InvalidAgeException;
import com.mailsending.exception.InvalidEmailIdException;
import com.mailsending.exception.InvalidPasswordException;
import com.mailsending.exception.InvalidUsernameException;
import com.mailsending.model.Employee;
import com.mailsending.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	@Autowired 
	EmployeeRepository er;
	@Autowired 
	JavaMailSender sender;
	
	@Value("$spring.mail.username")
	private static String SEND_MAIL;
	
	@Override
	public Employee addEmployee(Employee emp) {
		Employee e=er.save(emp);
		SimpleMailMessage simsg=new SimpleMailMessage();
		simsg.setTo(emp.getEmailid());
		simsg.setFrom(SEND_MAIL);
		simsg.setSubject("about registreation for Drive.");
		simsg.setText("Hi "+emp.getFullname()+"/n Your registration for upcoming drive is done successfully..");
		simsg.setCc("shubhamgulhane777@gmail.com");
		simsg.setCc("aartigulhane404@gmail.com");
		sender.send(simsg);
		return e;
	}

	@Override
	public Employee regEmp(Employee employee){
		
		
		if(employee.getUsername().equals(employee.getEmailid()))
		{
			if(employee.getAge()>18)
			{
				if(employee.getEmailid().endsWith("@gmail.com"))
				{
					if(employee.getPassword().length()==8)
					{
						Employee e=er.save(employee);
						SimpleMailMessage simsg=new SimpleMailMessage();
						simsg.setTo(employee.getEmailid());
						simsg.setFrom(SEND_MAIL);
						simsg.setSubject("about registreation for Drive.");
						simsg.setText("Hi "+employee.getFullname()+"/n Your registration for upcoming drive is done successfully..");
						simsg.setCc("shubhamgulhane777@gmail.com");
						sender.send(simsg);
						return e;
					}else {
						throw new InvalidPasswordException("Password should be 8 character");
					}
					
				}else {
					throw new InvalidEmailIdException("Email id is invalid");
				}
				
			}else {
				throw new InvalidAgeException("Age should be gretter then 18");
			}
		}else {
			throw new InvalidUsernameException("Username and Email id must be same");
		}
	
	}

}
