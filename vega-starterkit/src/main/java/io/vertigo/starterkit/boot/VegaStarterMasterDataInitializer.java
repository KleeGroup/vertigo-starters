/**
 *
 */
package io.vertigo.starterkit.boot;

import io.vertigo.datastore.impl.entitystore.AbstractMasterDataDefinitionProvider;
import lollipop.domain.users.Profil;
import lollipop.domain.users.SecurityRole;

/**
 * Init masterdata list.
 * @author jmforhan
 */
public class VegaStarterMasterDataInitializer extends AbstractMasterDataDefinitionProvider {

	@Override
	public void declareMasterDataLists() {
		registerDtMasterDatas(Profil.class);
		registerDtMasterDatas(SecurityRole.class);

	}

}
