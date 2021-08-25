package codegym.service;

import codegym.model.ClassRoom;
import codegym.repository.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ClassRoomService implements IClassRoomService{
    @Autowired
    IClassRoomRepository classRoomRepository;
    @Override
    public ArrayList<ClassRoom> findAll() {
        return (ArrayList<ClassRoom>) classRoomRepository.findAll();
    }

    @Override
    public ClassRoom findById(long id) {
        return classRoomRepository.findById(id).get();
    }
}
