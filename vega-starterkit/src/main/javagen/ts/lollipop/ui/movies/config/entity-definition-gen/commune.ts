/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface Commune {
	idInsee: number;
	codePostal?: string;
	commune?: string;
	departement?: string;
}

export interface CommuneNode extends StoreNode<Commune> {
	idInsee: EntityField<number, typeof domains.DoId>;
	codePostal: EntityField<string, typeof domains.DoCodePostal>;
	commune: EntityField<string, typeof domains.DoLabel>;
	departement: EntityField<string, typeof domains.DoLabel>;
}

export const CommuneEntity = {
    name: "commune",
    fields: {
        idInsee: {
            name: "idInsee",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "movies.commune.idInsee"
        },
        codePostal: {
            name: "codePostal",
            type: "field" as "field",
            domain: domains.DoCodePostal,
            isRequired: false,
            translationKey: "movies.commune.codePostal"
        },
        commune: {
            name: "commune",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.commune.commune"
        },
        departement: {
            name: "departement",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.commune.departement"
        }
    }
};
