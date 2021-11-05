package com.example.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entity.Category;
import com.example.entity.Role;
import com.example.repository.CategoryRepository;
import com.example.repository.RoleRepository;
import com.example.util.Util;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			Role role = new Role("ROLE_ADMIN");
			role.setId("role_" + Util.generateId());
			roleRepository.save(role);
		}

		if (roleRepository.findByName("ROLE_MEMBER") == null) {
			Role role = new Role("ROLE_MEMBER");
			role.setId("role_" + Util.generateId());
			roleRepository.save(role);
		}
		
		if (categoryRepository.findByName("Action") == null) {
			Category category = new Category("Action");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}

		if (categoryRepository.findByName("Classics") == null) {
			Category category = new Category("Classics");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Cooking") == null) {
			Category category = new Category("Cooking");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Fantasy") == null) {
			Category category = new Category("Fantasy");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("History") == null) {
			Category category = new Category("History");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Horror") == null) {
			Category category = new Category("Horror");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Kids") == null) {
			Category category = new Category("Kids");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Mystery") == null) {
			Category category = new Category("Mystery");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Romance") == null) {
			Category category = new Category("Romance");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}

		if (categoryRepository.findByName("Science Fiction") == null) {
			Category category = new Category("Science Fiction");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
		
		if (categoryRepository.findByName("Other") == null) {
			Category category = new Category("Other");
			category.setId("category_" + Util.generateId());
			categoryRepository.save(category);
		}
	}

}
