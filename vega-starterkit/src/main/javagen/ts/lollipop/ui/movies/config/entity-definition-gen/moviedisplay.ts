/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface MovieDisplay {
	movId?: number;
	title?: string;
}

export interface MovieDisplayNode extends StoreNode<MovieDisplay> {
	movId: EntityField<number, typeof domains.DoId>;
	title: EntityField<string, typeof domains.DoLabel>;
}

export const MovieDisplayEntity = {
    name: "movieDisplay",
    fields: {
        movId: {
            name: "movId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: false,
            translationKey: "movies.movieDisplay.movId"
        },
        title: {
            name: "title",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.movieDisplay.title"
        }
    }
};
