/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface People {
	peoId: number;
	lastName?: string;
	firstName?: string;
	peoName?: string;
	imdbid?: string;
}

export interface PeopleNode extends StoreNode<People> {
	peoId: EntityField<number, typeof domains.DoId>;
	lastName: EntityField<string, typeof domains.DoName>;
	firstName: EntityField<string, typeof domains.DoFirstname>;
	peoName: EntityField<string, typeof domains.DoLabelLong>;
	imdbid: EntityField<string, typeof domains.DoLabel>;
}

export const PeopleEntity = {
    name: "people",
    fields: {
        peoId: {
            name: "peoId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "people.people.peoId"
        },
        lastName: {
            name: "lastName",
            type: "field" as "field",
            domain: domains.DoName,
            isRequired: false,
            translationKey: "people.people.lastName"
        },
        firstName: {
            name: "firstName",
            type: "field" as "field",
            domain: domains.DoFirstname,
            isRequired: false,
            translationKey: "people.people.firstName"
        },
        peoName: {
            name: "peoName",
            type: "field" as "field",
            domain: domains.DoLabelLong,
            isRequired: false,
            translationKey: "people.people.peoName"
        },
        imdbid: {
            name: "imdbid",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "people.people.imdbid"
        }
    }
};
