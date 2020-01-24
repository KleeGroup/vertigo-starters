/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface ApplicationUser {
	usrId: number;
	lastName?: string;
	firstName?: string;
	email?: string;
	proId?: number;
}

export interface ApplicationUserNode extends StoreNode<ApplicationUser> {
	usrId: EntityField<number, typeof domains.DoId>;
	lastName: EntityField<string, typeof domains.DoName>;
	firstName: EntityField<string, typeof domains.DoFirstname>;
	email: EntityField<string, typeof domains.DoEmail>;
	proId: EntityField<number, typeof domains.DoId>;
}

export const ApplicationUserEntity = {
    name: "applicationUser",
    fields: {
        usrId: {
            name: "usrId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "users.applicationUser.usrId"
        },
        lastName: {
            name: "lastName",
            type: "field" as "field",
            domain: domains.DoName,
            isRequired: false,
            translationKey: "users.applicationUser.lastName"
        },
        firstName: {
            name: "firstName",
            type: "field" as "field",
            domain: domains.DoFirstname,
            isRequired: false,
            translationKey: "users.applicationUser.firstName"
        },
        email: {
            name: "email",
            type: "field" as "field",
            domain: domains.DoEmail,
            isRequired: false,
            translationKey: "users.applicationUser.email"
        },
        proId: {
            name: "proId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: false,
            translationKey: "users.applicationUser.proId"
        }
    }
};
