import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react"; // Under the hood it uses RTK query and Thunk middleware is built-in.
import { BASE_URL } from "../constants.js";

// You have to put baseUrl to 'https://{yourapiurl}', Because we are using proxy in dev so we are leaving it empty.
const baseQuery = fetchBaseQuery({ baseUrl: BASE_URL });

export const apiSlice = createApi({
  baseQuery,
  // Tag type is used for caching.
  tagTypes: ["Vehicle"],
  // Built-in builder to make our request and Acts as a parent for our apiSlices.
  endpoints: (builder) => ({}),
});
