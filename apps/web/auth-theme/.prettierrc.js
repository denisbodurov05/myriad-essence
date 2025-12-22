import sharedConfig from "@myriad-essence/prettier-config/index.json" with { type: "json" };

export default {
    ...sharedConfig,
    overrides: [
        {
            files: [
                "**/login/pages/*.tsx",
                "**/account/pages/*.tsx",
                "**/login/Template.tsx",
                "**/account/Template.tsx",
                "**/login/UserProfileFormFields.tsx",
                "KcApp.tsx"
            ],
            options: {
                printWidth: 150
            }
        }
    ]
};
