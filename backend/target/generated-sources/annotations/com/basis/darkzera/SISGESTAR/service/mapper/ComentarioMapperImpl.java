package com.basis.darkzera.SISGESTAR.service.mapper;

import com.basis.darkzera.SISGESTAR.domain.Comentario;
import com.basis.darkzera.SISGESTAR.domain.Tarefa;
import com.basis.darkzera.SISGESTAR.domain.Usuario;
import com.basis.darkzera.SISGESTAR.service.dto.ComentarioDTO;
import com.basis.darkzera.SISGESTAR.service.dto.ComentarioListDTO;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-21T19:02:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class ComentarioMapperImpl implements ComentarioMapper {

    @Autowired
    private TarefaMapper tarefaMapper;

    @Override
    public ComentarioDTO toDTO(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        ComentarioDTO comentarioDTO = new ComentarioDTO();

        comentarioDTO.setIdUsuario( comentarioUsuarioId( comentario ) );
        comentarioDTO.setIdTarefa( comentarioTarefaId( comentario ) );
        comentarioDTO.setId( comentario.getId() );
        comentarioDTO.setTitulo( comentario.getTitulo() );
        comentarioDTO.setDescricao( comentario.getDescricao() );
        comentarioDTO.setData_comentario( comentario.getData_comentario() );

        return comentarioDTO;
    }

    @Override
    public Comentario toEntity(ComentarioDTO comentarioDTO) {
        if ( comentarioDTO == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setUsuario( comentarioDTOToUsuario( comentarioDTO ) );
        comentario.setTarefa( comentarioDTOToTarefa( comentarioDTO ) );
        comentario.setId( comentarioDTO.getId() );
        comentario.setTitulo( comentarioDTO.getTitulo() );
        comentario.setDescricao( comentarioDTO.getDescricao() );
        comentario.setData_comentario( comentarioDTO.getData_comentario() );

        return comentario;
    }

    @Override
    public ComentarioListDTO toListDTO(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        ComentarioListDTO comentarioListDTO = new ComentarioListDTO();

        comentarioListDTO.setIdUsuario( comentarioUsuarioId( comentario ) );
        comentarioListDTO.setId( comentario.getId() );
        comentarioListDTO.setDescricao( comentario.getDescricao() );
        comentarioListDTO.setData_comentario( comentario.getData_comentario() );

        return comentarioListDTO;
    }

    private Long comentarioUsuarioId(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }
        Usuario usuario = comentario.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long comentarioTarefaId(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }
        Tarefa tarefa = comentario.getTarefa();
        if ( tarefa == null ) {
            return null;
        }
        Long id = tarefa.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Usuario comentarioDTOToUsuario(ComentarioDTO comentarioDTO) {
        if ( comentarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( comentarioDTO.getIdUsuario() );

        return usuario;
    }

    protected Tarefa comentarioDTOToTarefa(ComentarioDTO comentarioDTO) {
        if ( comentarioDTO == null ) {
            return null;
        }

        Tarefa tarefa = new Tarefa();

        tarefa.setId( comentarioDTO.getIdTarefa() );

        tarefaMapper.verificarElementosNulos( tarefa );

        return tarefa;
    }
}
