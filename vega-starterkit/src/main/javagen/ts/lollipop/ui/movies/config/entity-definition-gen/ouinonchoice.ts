/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface OuiNonChoice {
	key: boolean;
	libelle?: string;
}

export interface OuiNonChoiceNode extends StoreNode<OuiNonChoice> {
	key: EntityField<boolean, typeof domains.DoOuiNon>;
	libelle: EntityField<string, typeof domains.DoLabel>;
}

export const OuiNonChoiceEntity = {
    name: "ouiNonChoice",
    fields: {
        key: {
            name: "key",
            type: "field" as "field",
            domain: domains.DoOuiNon,
            isRequired: true,
            translationKey: "movies.ouiNonChoice.key"
        },
        libelle: {
            name: "libelle",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.ouiNonChoice.libelle"
        }
    }
};
