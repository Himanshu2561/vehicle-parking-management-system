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

    getTotalNoOfVehicles: builder.query({
      query: () => ({
        url: `${VEHICLES_URL}/totalEntries`,
      }),
      keepUnusedDataFor: 5,
    }),

    getLastSevenDayAmount: builder.query({
      query: () => ({
        url: `${VEHICLES_URL}/lasSevenDaysAmount`,
      }),
      keepUnusedDataFor: 5,
    }),

    getVehicleDetails: builder.query({
      query: (vehicleId) => ({
        url: `${VEHICLES_URL}/search/${vehicleId}`,
      }),
      keepUnusedDataFor: 5,
    }),
  }),
});

export const {
  useGetVehiclesQuery,
  useAddVehicleMutation,
  useGetTotalNoOfVehiclesQuery,
  useGetLastSevenDayAmountQuery,
  useGetVehicleDetailsQuery
} = vehicleApiSlice;
