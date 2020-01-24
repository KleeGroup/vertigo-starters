/*
    Ce fichier a été généré automatiquement.
    Toute modification sera perdue.
*/

/* tslint:disable */
import { EntityField, StoreNode } from "focus4/entity";
import * as domains from "../../../../00-core/domain"

export interface MovieIndex {
	movId?: number;
	title?: string;
	titleSortOnly?: string;
	originalTitle?: string;
	synopsis?: string;
	shortSynopsis?: string;
	keywords?: string;
	poster?: string;
	runtime?: number;
	movieType?: string;
	productionYear?: number;
	userRating?: number;
	pressRating?: number;
	camera?: string;
}

export interface MovieIndexNode extends StoreNode<MovieIndex> {
	movId: EntityField<number, typeof domains.DoId>;
	title: EntityField<string, typeof domains.DoLabel>;
	titleSortOnly: EntityField<string, typeof domains.DoTextNotTokenized>;
	originalTitle: EntityField<string, typeof domains.DoLabel>;
	synopsis: EntityField<string, typeof domains.DoText>;
	shortSynopsis: EntityField<string, typeof domains.DoText>;
	keywords: EntityField<string, typeof domains.DoLabel>;
	poster: EntityField<string, typeof domains.DoTextNotTokenized>;
	runtime: EntityField<number, typeof domains.DoDuration>;
	movieType: EntityField<string, typeof domains.DoLabel>;
	productionYear: EntityField<number, typeof domains.DoYear>;
	userRating: EntityField<number, typeof domains.DoRating>;
	pressRating: EntityField<number, typeof domains.DoRating>;
	camera: EntityField<string, typeof domains.DoMultiValues>;
}

export const MovieIndexEntity = {
    name: "movieIndex",
    fields: {
        movId: {
            name: "movId",
            type: "field" as "field",
            domain: domains.DoId,
            isRequired: false,
            translationKey: "movies.movieIndex.movId"
        },
        title: {
            name: "title",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.movieIndex.title"
        },
        titleSortOnly: {
            name: "titleSortOnly",
            type: "field" as "field",
            domain: domains.DoTextNotTokenized,
            isRequired: false,
            translationKey: "movies.movieIndex.titleSortOnly"
        },
        originalTitle: {
            name: "originalTitle",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.movieIndex.originalTitle"
        },
        synopsis: {
            name: "synopsis",
            type: "field" as "field",
            domain: domains.DoText,
            isRequired: false,
            translationKey: "movies.movieIndex.synopsis"
        },
        shortSynopsis: {
            name: "shortSynopsis",
            type: "field" as "field",
            domain: domains.DoText,
            isRequired: false,
            translationKey: "movies.movieIndex.shortSynopsis"
        },
        keywords: {
            name: "keywords",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.movieIndex.keywords"
        },
        poster: {
            name: "poster",
            type: "field" as "field",
            domain: domains.DoTextNotTokenized,
            isRequired: false,
            translationKey: "movies.movieIndex.poster"
        },
        runtime: {
            name: "runtime",
            type: "field" as "field",
            domain: domains.DoDuration,
            isRequired: false,
            translationKey: "movies.movieIndex.runtime"
        },
        movieType: {
            name: "movieType",
            type: "field" as "field",
            domain: domains.DoLabel,
            isRequired: false,
            translationKey: "movies.movieIndex.movieType"
        },
        productionYear: {
            name: "productionYear",
            type: "field" as "field",
            domain: domains.DoYear,
            isRequired: false,
            translationKey: "movies.movieIndex.productionYear"
        },
        userRating: {
            name: "userRating",
            type: "field" as "field",
            domain: domains.DoRating,
            isRequired: false,
            translationKey: "movies.movieIndex.userRating"
        },
        pressRating: {
            name: "pressRating",
            type: "field" as "field",
            domain: domains.DoRating,
            isRequired: false,
            translationKey: "movies.movieIndex.pressRating"
        },
        camera: {
            name: "camera",
            type: "field" as "field",
            domain: domains.DoMultiValues,
            isRequired: false,
            translationKey: "movies.movieIndex.camera"
        }
    }
};
