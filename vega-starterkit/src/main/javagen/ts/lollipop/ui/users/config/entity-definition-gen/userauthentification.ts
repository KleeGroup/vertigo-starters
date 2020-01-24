/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface UserAuthentification {
	authId: number;
	login?: string;
	password?: string;
	usrId: number;
}

export interface UserAuthentificationNode extends StoreNode<UserAuthentification> {
	authId: EntityField<number, typeof domains.DoId>;
	login: EntityField<string, typeof domains.DoLabelShort>;
	password: EntityField<string, typeof domains.DoPassword>;
	usrId: EntityField<number, typeof domains.DoId>;
}

export const UserAuthentificationEntity = {
    name: "userAuthentification",
    fields: {
        authId: {
            name: "authId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "users.userAuthentification.authId"
        },
        login: {
            name: "login",
            type: "field" as "field",
            domain: domains.DoLabelShort,
            isRequired: false,
            translationKey: "users.userAuthentification.login"
        },
        password: {
            name: "password",
            type: "field" as "field",
            domain: domains.DoPassword,
            isRequired: false,
            translationKey: "users.userAuthentification.password"
        },
        usrId: {
            name: "usrId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "users.userAuthentification.usrId"
        }
    }
};
