package com.basis.darkzera.SISGESTAR.service.mapper;

import com.basis.darkzera.SISGESTAR.domain.Comentario;
import com.basis.darkzera.SISGESTAR.domain.Tarefa;
import com.basis.darkzera.SISGESTAR.domain.Usuario;
import com.basis.darkzera.SISGESTAR.service.dto.ComentarioListDTO;
import com.basis.darkzera.SISGESTAR.service.dto.TarefaDTO;
import com.basis.darkzera.SISGESTAR.service.dto.TarefaListDTO;
import com.basis.darkzera.SISGESTAR.service.dto.UsuarioListDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-21T19:02:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class TarefaMapperImpl implements TarefaMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public TarefaDTO toDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaDTO tarefaDTO = new TarefaDTO();

        tarefaDTO.setIdResponsavel( tarefaResponsavelId( tarefa ) );
        tarefaDTO.setId( tarefa.getId() );
        tarefaDTO.setNome( tarefa.getNome() );
        tarefaDTO.setDescricao( tarefa.getDescricao() );
        tarefaDTO.setIdStatus( tarefa.getIdStatus() );
        tarefaDTO.setAcompanhadores( usuarioListToUsuarioListDTOList( tarefa.getAcompanhadores() ) );
        tarefaDTO.setComentarios( comentarioListToComentarioListDTOList( tarefa.getComentarios() ) );
        tarefaDTO.setDataAbertura( tarefa.getDataAbertura() );
        tarefaDTO.setDataFechamento( tarefa.getDataFechamento() );

        return tarefaDTO;
    }

    @Override
    public Tarefa toEntity(TarefaDTO tarefaDTO) {
        if ( tarefaDTO == null ) {
            return null;
        }

        Tarefa tarefa = new Tarefa();

        tarefa.setResponsavel( tarefaDTOToUsuario( tarefaDTO ) );
        tarefa.setId( tarefaDTO.getId() );
        tarefa.setNome( tarefaDTO.getNome() );
        tarefa.setDescricao( tarefaDTO.getDescricao() );
        tarefa.setAcompanhadores( usuarioListDTOListToUsuarioList( tarefaDTO.getAcompanhadores() ) );
        tarefa.setIdStatus( tarefaDTO.getIdStatus() );
        tarefa.setDataAbertura( tarefaDTO.getDataAbertura() );
        tarefa.setDataFechamento( tarefaDTO.getDataFechamento() );
        tarefa.setComentarios( comentarioListDTOListToComentarioList( tarefaDTO.getComentarios() ) );

        verificarElementosNulos( tarefa );

        return tarefa;
    }

    @Override
    public TarefaListDTO toListDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaListDTO tarefaListDTO = new TarefaListDTO();

        tarefaListDTO.setId( tarefa.getId() );
        tarefaListDTO.setNome( tarefa.getNome() );

        return tarefaListDTO;
    }

    private Long tarefaResponsavelId(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }
        Usuario responsavel = tarefa.getResponsavel();
        if ( responsavel == null ) {
            return null;
        }
        Long id = responsavel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<UsuarioListDTO> usuarioListToUsuarioListDTOList(List<Usuario> list) {
        if ( list == null ) {
            return null;
        }

        List<UsuarioListDTO> list1 = new ArrayList<UsuarioListDTO>( list.size() );
        for ( Usuario usuario : list ) {
            list1.add( usuarioMapper.toListDTO( usuario ) );
        }

        return list1;
    }

    protected ComentarioListDTO comentarioToComentarioListDTO(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        ComentarioListDTO comentarioListDTO = new ComentarioListDTO();

        comentarioListDTO.setId( comentario.getId() );
        comentarioListDTO.setDescricao( comentario.getDescricao() );
        comentarioListDTO.setData_comentario( comentario.getData_comentario() );

        return comentarioListDTO;
    }

    protected List<ComentarioListDTO> comentarioListToComentarioListDTOList(List<Comentario> list) {
        if ( list == null ) {
            return null;
        }

        List<ComentarioListDTO> list1 = new ArrayList<ComentarioListDTO>( list.size() );
        for ( Comentario comentario : list ) {
            list1.add( comentarioToComentarioListDTO( comentario ) );
        }

        return list1;
    }

    protected Usuario tarefaDTOToUsuario(TarefaDTO tarefaDTO) {
        if ( tarefaDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( tarefaDTO.getIdResponsavel() );

        return usuario;
    }

    protected Usuario usuarioListDTOToUsuario(UsuarioListDTO usuarioListDTO) {
        if ( usuarioListDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioListDTO.getId() );
        usuario.setName( usuarioListDTO.getName() );

        return usuario;
    }

    protected List<Usuario> usuarioListDTOListToUsuarioList(List<UsuarioListDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Usuario> list1 = new ArrayList<Usuario>( list.size() );
        for ( UsuarioListDTO usuarioListDTO : list ) {
            list1.add( usuarioListDTOToUsuario( usuarioListDTO ) );
        }

        return list1;
    }

    protected Comentario comentarioListDTOToComentario(ComentarioListDTO comentarioListDTO) {
        if ( comentarioListDTO == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setId( comentarioListDTO.getId() );
        comentario.setDescricao( comentarioListDTO.getDescricao() );
        comentario.setData_comentario( comentarioListDTO.getData_comentario() );

        return comentario;
    }

    protected List<Comentario> comentarioListDTOListToComentarioList(List<ComentarioListDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Comentario> list1 = new ArrayList<Comentario>( list.size() );
        for ( ComentarioListDTO comentarioListDTO : list ) {
            list1.add( comentarioListDTOToComentario( comentarioListDTO ) );
        }

        return list1;
    }
}
