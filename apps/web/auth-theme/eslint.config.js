import sharedConfig from "@myriad-essence/eslint-config";
import storybook from "eslint-plugin-storybook";
import typescriptEslint from "typescript-eslint";

export default [
  ...sharedConfig,
  ...storybook.configs["flat/recommended"],
  {
    ignores: ["dist/**", "public/**"],
  },
  {
    files: ["**/*.stories.*"],
    rules: {
      "import/no-anonymous-default-export": "off",
    },
  },
];
