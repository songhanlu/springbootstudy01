package com.example.demo;

import com.example.demo.entity.Department;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Study001ApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void tt001(){
		//Department department = new Department();
		//department.setName("人力资源部");
		//departmentRepository.save(department);

		//Role role = new Role();
		//role.setName("employee");
		//roleRepository.save(role);

		//List<Role> roles = new ArrayList<>();
		//roles.add(role);

		User user = new User();
		user.setName("宋含猪");
		user.setCreateDate(new Date());
		user.setDepartment(departmentRepository.findByName("人力资源部"));
		user.setRoles(roleRepository.findAllByName("employee"));

		userRepository.save(user);

	}

	@Test
	public void tt002(){
		Random random = new Random();
		List<Department> departments = departmentRepository.findAll();
		int deptSize = departments.size();
		List<Role> roles = roleRepository.findAll();
		int roleSize = roles.size();

		for (int i = 0; i < 50; i++) {
			List<Role> rolesForUser = new ArrayList<>();
			rolesForUser.add(roles.get(random.nextInt(roleSize)));
			Department department = departments.get(random.nextInt(deptSize));
			User user = new User();
			user.setName("宋含" + i);
			user.setCreateDate(new Date());
			user.setRoles(rolesForUser);
			user.setDepartment(department);
			userRepository.save(user);
		}
	}

	@Test
	public void findPage(){
		Pageable pageable = new PageRequest(10, 20, new Sort(Sort.Direction.ASC, "id"));
		Page<User> page = userRepository.findAll(pageable);
		for (User user : page.getContent()) {
			System.out.println("====user====  name: " + user.getName() + ", department: " + user.getDepartment().getName() + ", role: " + user.getRoles().get(0).getName());
		}
	}

}
