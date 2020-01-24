/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface Profil {
	proId: number;
	label?: string;
}

export interface ProfilNode extends StoreNode<Profil> {
	proId: EntityField<number, typeof domains.DoId>;
	label: EntityField<string, typeof domains.DoLabel>;
}

export const ProfilEntity = {
    name: "profil",
    fields: {
        proId: {
            name: "proId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "users.profil.proId"
        },
        label: {
            name: "label",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "users.profil.label"
        }
    }
};
