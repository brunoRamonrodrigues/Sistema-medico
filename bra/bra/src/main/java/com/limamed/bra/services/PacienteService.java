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

        pacienteModel.setCEP(dados.getCep());
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

            pacienteDto.setCep(pacienteModel.getCEP());
            pacienteDto.setNome(pacienteModel.getNome());
            pacienteDto.setCpf(pacienteModel.getCpf());
            pacienteDto.setTelefone(pacienteModel.getTelefone());
            pacienteDto.setDatanascimento(pacienteModel.getDatanascimento());

            pacienteListaDto.add(pacienteDto);
        }

        return pacienteListaDto;
    }

    //Lista por ID
    public PacienteDto listaPaciente(Long id){
        Optional<PacienteModel> pacienteOP = pacienteRepository.findById(id);

        if (pacienteOP.isEmpty()){
            return null;
        }
        PacienteDto pacienteDto = new PacienteDto();

        pacienteDto.setId(pacienteOP.get().getId());
        pacienteDto.setCep(pacienteOP.get().getCEP());
        pacienteDto.setDatanascimento(pacienteOP.get().getDatanascimento());
        pacienteDto.setCpf(pacienteOP.get().getCpf());
        pacienteDto.setNome(pacienteOP.get().getNome());

        return pacienteDto;
    }

    //Atualizar
    public Boolean atualizarPaciente(Long id, PacienteDto dados){
        Optional<PacienteModel> pacienteOP = pacienteRepository.findById(id);

        if (pacienteOP.isEmpty()){
            return false;
        }

        PacienteModel paciente = pacienteOP.get();

        paciente.setNome(dados.getNome());
        paciente.setCpf(dados.getCpf());
        paciente.setTelefone(dados.getTelefone());
        paciente.setDatanascimento(dados.getDatanascimento());

        pacienteRepository.save(paciente);
        return true;
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
