import com.example.FinalCodeVehicle.entity.Slots;
import com.example.FinalCodeVehicle.entity.Ticket;
import com.example.FinalCodeVehicle.entity.Vehicle;
import com.example.FinalCodeVehicle.repository.SlotRepository;
import com.example.FinalCodeVehicle.repository.TicketRepository;
import com.example.FinalCodeVehicle.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService{

    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    private SlotRepository slotRepository;

    @Autowired
    public VehicleServiceImplementation(VehicleRepository vehicleRepository,
                                        TicketRepository ticketRepository,
                                        SlotRepository slotRepository){
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Transactional
    @Override
    public void removeVehicleByTicketId(Integer ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        Vehicle vehicle = ticket.getVehicle();
        Slots slot = slotRepository.findByVehicleId(vehicle.getId());

        // Delete the associated slot and ticket
        if (slot != null) {
            slotRepository.delete(slot);
        }
        ticketRepository.delete(ticket);
        // delete the associated vehicle
        vehicleRepository.delete(vehicle);
    }
}