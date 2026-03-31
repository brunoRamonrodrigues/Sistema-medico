package com.limamed.bra.services;

import com.limamed.bra.dtos.PacienteDto;
import com.limamed.bra.models.PacienteModel;
import com.limamed.bra.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    //Criar
    public Boolean criarPaciente(PacienteDto dados){
        PacienteModel pacienteModel = new PacienteModel();

        pacienteModel.setCEP(dados.getCEP());
        pacienteModel.setNome(dados.getNome());
        pacienteModel.setCpf(dados.getCpf());
        pacienteModel.setTelefone(dados.getTelefone());
        pacienteModel.setDatanascimento(dados.getDatanascimento());

        pacienteRepository.save(pacienteModel);

        return true;
    }

    //Ler
    public List<PacienteDto> listaPacientes(){
        List<PacienteDto> pacienteListaDto = new ArrayList<>();
        List<PacienteModel> pacienteLista = pacienteRepository.findAll();

        for (PacienteModel pacienteModel : pacienteLista){
            PacienteDto pacienteDto = new PacienteDto();

            pacienteDto.setCEP(pacienteModel.getCEP());
            pacienteDto.setNome(pacienteModel.getNome());
            pacienteDto.setCpf(pacienteModel.getCpf());
            pacienteDto.setTelefone(pacienteModel.getTelefone());
            pacienteDto.setDatanascimento(pacienteModel.getDatanascimento());

            pacienteListaDto.add(pacienteDto);
        }

        return pacienteListaDto;
    }

    //Delete
    public Boolean excluirPaciente(Long id){

        Optional<PacienteModel> pacienteOp = pacienteRepository.findById(id);
        if (pacienteOp.isEmpty()){
            return false;
        }
        pacienteRepository.delete(pacienteOp.get());
        return true;
    }



}
