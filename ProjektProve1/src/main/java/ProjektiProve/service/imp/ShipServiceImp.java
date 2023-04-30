package ProjektiProve.service.imp;
import ProjektiProve.dto.ShipDTO;
import ProjektiProve.mapper.ShipMapper;
import ProjektiProve.model.Ship;
import ProjektiProve.exception.ResourceNotFountException;
import ProjektiProve.repository.ShipRepository;
import ProjektiProve.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipServiceImp implements ShipService {


    private final ShipRepository shipRepository;


    @Override
    public ShipDTO registerShip(ShipDTO req) {
        Ship sh = ShipMapper.toEntity(req);
        if (sh.getId()==null)
            sh = shipRepository.save(sh);
        return ShipMapper.toDTO(sh);
    }

    @Override
    public Ship findById(Integer id) {
        return shipRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Ship with id %s not found " , id)));
    }

    @Override
    public ShipDTO updateShip(Integer id, ShipDTO req) {
        Ship sh = findById(id);
        sh = ShipMapper.buildUpdateShip(sh,req);
        return ShipMapper.toUpdateDto(shipRepository.save(sh));
    }

    @Override
    public Void deleteshipbyid(Integer id) {
        Ship sh = shipRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("user with id %s not found",id)));
        shipRepository.delete(sh);
        return null;


    }


}
