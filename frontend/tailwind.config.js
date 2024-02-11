/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        "pallet-1": "#361d32",
        "pallet-2": "#543c52",
        "pallet-3": "#f55951",
        "pallet-4": "#edd2cb",
        "pallet-5": "#f1e8e6",
      },
    },
  },
  plugins: [],
};
