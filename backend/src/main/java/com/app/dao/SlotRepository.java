import com.example.FinalCodeVehicle.entity.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SlotRepository extends JpaRepository<Slots, Integer> {
    @Query("SELECT s FROM Slots s WHERE s.vehicle IS NULL ORDER BY s.slotNumber ASC")
    public List<Slots> findAllAvailableSlotsOrderBySlotNumberAsc();

    // checking whether a particular slot exists in the database or not
    @Query("SELECT COUNT(s) > 0 FROM Slots s WHERE s.slotNumber = :slotNumber")
    boolean existsBySlotNumber(Integer slotNumber);

    // getting a particular slot from the database
    @Query("SELECT s FROM Slots s WHERE s.slotNumber = :slotNumber")
    Slots findBySlotNumber(@Param("slotNumber") int slotNumber);

    @Query("SELECT s FROM Slots s WHERE s.vehicle = :vehicleId")
    Slots findByVehicleId(@Param("vehicleId") Integer vehicleId);
}