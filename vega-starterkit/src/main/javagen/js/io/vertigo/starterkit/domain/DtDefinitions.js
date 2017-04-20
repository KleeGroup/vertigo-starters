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
