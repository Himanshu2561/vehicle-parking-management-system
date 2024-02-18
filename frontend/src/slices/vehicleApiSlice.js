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

    addVehicle: builder.mutation({
      query: (data) => ({
        url: `${VEHICLES_URL}/addVehicle`,
        method: "POST",
        body: data,
      }),
      invalidatesTags: ["Vehicles"],
    }),
  }),
});

export const { useGetVehiclesQuery, useAddVehicleMutation } = vehicleApiSlice;
