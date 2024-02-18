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
        url: `${VEHICLES_URL}/lastSevenDaysAmount`,
      }),
      keepUnusedDataFor: 5,
    }),

    getLastThirtyDayAmount: builder.query({
      query: () => ({
        url: `${VEHICLES_URL}/lastThirtyDaysAmount`,
      }),
      keepUnusedDataFor: 5,
    }),

    getVehicleDetail: builder.query({
      query: (vehicleId) => ({
        url: `${VEHICLES_URL}/search/${vehicleId}`,
      }),
      keepUnusedDataFor: 5,
    }),

    deleteVehicle: builder.mutation({
      query: (vehicleId) => ({
        url: `${VEHICLES_URL}/removeVehicle/${vehicleId}`,
        method: "DELETE",
      }),
      providesTags: ["Vehicles"],
    }),
  }),
});

export const {
  useGetVehiclesQuery,
  useAddVehicleMutation,
  useGetTotalNoOfVehiclesQuery,
  useGetLastSevenDayAmountQuery,
  useLazyGetVehicleDetailQuery,
  useDeleteVehicleMutation,
  useGetLastThirtyDayAmountQuery
} = vehicleApiSlice;
