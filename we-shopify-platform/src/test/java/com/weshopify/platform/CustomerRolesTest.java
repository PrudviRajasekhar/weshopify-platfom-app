package com.weshopify.platform;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import com.weshopify.platform.features.customers.models.RoleToPermissions;
import com.weshopify.platform.features.customers.models.UserPermissions;
import com.weshopify.platform.features.customers.models.UserRole;
import com.weshopify.platform.features.customers.repository.UserPermissionsDataRepo;
import com.weshopify.platform.features.customers.repository.UserRolesDataRepo;

@Import(value = CustomerPermissionsTest.class)
public class CustomerRolesTest extends WeShopifyPlatformApplicationTests{

	@Autowired
	private UserPermissionsDataRepo permissionsDataRepo;
	
	@Autowired
	private UserRolesDataRepo roleDataRepo;
	
	@Test
	public void testCreateRole() {
		UserRole role = new UserRole();
		role.setRole("admin");
		role.setDescription("admin");
		
		List<UserPermissions> permissionsList = permissionsDataRepo.findAll();
		assertNotNull(permissionsList);
		assertNotNull(permissionsList.size());
		List<RoleToPermissions> roleActionsList = new ArrayList<RoleToPermissions>();
		permissionsList.stream().forEach(permission->{
			RoleToPermissions roleToAction = new RoleToPermissions();
			roleToAction.setPermissions(permission);
			roleToAction.setRole(role);
			
			roleActionsList.add(roleToAction);
		});
		role.setActions(roleActionsList);
		roleDataRepo.save(role);
		assertNotNull(role.getId());
	}  
	
	
	
}
