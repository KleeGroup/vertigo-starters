/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface Movie {
	movId: number;
	title?: string;
	released?: string;
	year?: number;
	runtime?: number;
	description?: string;
	poster?: string;
	rated?: string;
	lastModified?: string;
}

export interface MovieNode extends StoreNode<Movie> {
	movId: EntityField<number, typeof domains.DoId>;
	title: EntityField<string, typeof domains.DoLabelLong>;
	released: EntityField<string, typeof domains.DoDate>;
	year: EntityField<number, typeof domains.DoYear>;
	runtime: EntityField<number, typeof domains.DoDuration>;
	description: EntityField<string, typeof domains.DoComment>;
	poster: EntityField<string, typeof domains.DoLabelLong>;
	rated: EntityField<string, typeof domains.DoLabelLong>;
	lastModified: EntityField<string, typeof domains.DoLastModified>;
}

export const MovieEntity = {
    name: "movie",
    fields: {
        movId: {
            name: "movId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: true,
            translationKey: "movies.movie.movId"
        },
        title: {
            name: "title",
            type: "field" as "field",
            domain: domains.DoLabelLong,
            isRequired: false,
            translationKey: "movies.movie.title"
        },
        released: {
            name: "released",
            type: "field" as "field",
            domain: domains.DoDate,
            isRequired: false,
            translationKey: "movies.movie.released"
        },
        year: {
            name: "year",
            type: "field" as "field",
            domain: domains.DoYear,
            isRequired: false,
            translationKey: "movies.movie.year"
        },
        runtime: {
            name: "runtime",
            type: "field" as "field",
            domain: domains.DoDuration,
            isRequired: false,
            translationKey: "movies.movie.runtime"
        },
        description: {
            name: "description",
            type: "field" as "field",
            domain: domains.DoComment,
            isRequired: false,
            translationKey: "movies.movie.description"
        },
        poster: {
            name: "poster",
            type: "field" as "field",
            domain: domains.DoLabelLong,
            isRequired: false,
            translationKey: "movies.movie.poster"
        },
        rated: {
            name: "rated",
            type: "field" as "field",
            domain: domains.DoLabelLong,
            isRequired: false,
            translationKey: "movies.movie.rated"
        },
        lastModified: {
            name: "lastModified",
            type: "field" as "field",
            domain: domains.DoLastModified,
            isRequired: false,
            translationKey: "movies.movie.lastModified"
        }
    }
};
