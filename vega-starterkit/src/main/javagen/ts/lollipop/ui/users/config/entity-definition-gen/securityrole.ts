/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface SecurityRole {
	sroCd: string;
	label?: string;
}

export interface SecurityRoleNode extends StoreNode<SecurityRole> {
	sroCd: EntityField<string, typeof domains.DoCode>;
	label: EntityField<string, typeof domains.DoLabel>;
}

export const SecurityRoleEntity = {
    name: "securityRole",
    fields: {
        sroCd: {
            name: "sroCd",
            type: "field" as "field",
            domain: domains.DoCode,
            isRequired: true,
            translationKey: "users.securityRole.sroCd"
        },
        label: {
            name: "label",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "users.securityRole.label"
        }
    }
};
