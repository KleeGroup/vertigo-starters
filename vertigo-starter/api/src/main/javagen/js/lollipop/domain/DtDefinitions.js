/**
 * These metadata are generated automatically.
 * @type {Object}
 */
module.exports = {
        applicationUser: {
        usrId: {
            domain: "DO_ID",
            required: true
        },
        lastName: {
            domain: "DO_NAME",
            required: false
        },
        firstName: {
            domain: "DO_FIRSTNAME",
            required: false
        },
        email: {
            domain: "DO_EMAIL",
            required: false
        },
        proId: {
            domain: "DO_ID",
            required: false
        }
    },
    casting: {
        castId: {
            domain: "DO_ID",
            required: true
        },
        characterName: {
            domain: "DO_LABEL_LONG",
            required: false
        },
        peoId: {
            domain: "DO_ID",
            required: true
        },
        movId: {
            domain: "DO_ID",
            required: true
        }
    },
    dummy: {
        dummyLong: {
            domain: "DO_ID",
            required: false
        }
    },
    movie: {
        movId: {
            domain: "DO_ID",
            required: true
        },
        title: {
            domain: "DO_LABEL_LONG",
            required: false
        },
        released: {
            domain: "DO_DATE",
            required: false
        },
        year: {
            domain: "DO_YEAR",
            required: false
        },
        runtime: {
            domain: "DO_DURATION",
            required: false
        },
        description: {
            domain: "DO_COMMENT",
            required: false
        },
        poster: {
            domain: "DO_LABEL_LONG",
            required: false
        },
        rated: {
            domain: "DO_LABEL_LONG",
            required: false
        }
    },
    people: {
        peoId: {
            domain: "DO_ID",
            required: true
        },
        lastName: {
            domain: "DO_NAME",
            required: false
        },
        firstName: {
            domain: "DO_FIRSTNAME",
            required: false
        },
        peoName: {
            domain: "DO_LABEL_LONG",
            required: false
        },
        imdbid: {
            domain: "DO_LABEL",
            required: false
        }
    },
    profil: {
        proId: {
            domain: "DO_ID",
            required: true
        },
        label: {
            domain: "DO_LABEL",
            required: false
        }
    },
    securityRole: {
        sroCd: {
            domain: "DO_CODE",
            required: true
        },
        label: {
            domain: "DO_LABEL",
            required: false
        }
    },
    userAuthentification: {
        authId: {
            domain: "DO_ID",
            required: true
        },
        login: {
            domain: "DO_LABEL_SHORT",
            required: false
        },
        password: {
            domain: "DO_PASSWORD",
            required: false
        },
        usrId: {
            domain: "DO_ID",
            required: true
        }
    }
};
