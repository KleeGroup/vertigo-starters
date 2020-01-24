/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface Casting {
	castId: number;
	characterName?: string;
	peoId: number;
	movId: number;
}

export interface CastingNode extends StoreNode<Casting> {
	castId: EntityField<number, typeof domains.DoId>;
	characterName: EntityField<string, typeof domains.DoLabelLong>;
	peoId: EntityField<number, typeof domains.DoId>;
	movId: EntityField<number, typeof domains.DoId>;
}

export const CastingEntity = {
    name: "casting",
    fields: {
        castId: {
            name: "castId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "people.casting.castId"
        },
        characterName: {
            name: "characterName",
            type: "field" as "field",
            domain: domains.DoLabelLong,
            isRequired: false,
            translationKey: "people.casting.characterName"
        },
        peoId: {
            name: "peoId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "people.casting.peoId"
        },
        movId: {
            name: "movId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "people.casting.movId"
        }
    }
};
