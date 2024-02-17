import { VEHICLES_URL } from "../constants.js";
import { apiSlice } from "./apiSlice.js";

export const vehicleApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    getVehicles: builder.query({
      query: () => ({
        url: VEHICLES_URL,
      }),
      providesTags: ["Vehicles"],
      keepUnusedDataFor: 5,
    }),
  }),
});

export const { useGetVehiclesQuery } = vehicleApiSlice;
