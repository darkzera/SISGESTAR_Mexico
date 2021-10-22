package com.basis.darkzera.SISGESTAR.service.mapper;

import com.basis.darkzera.SISGESTAR.domain.Comentario;
import com.basis.darkzera.SISGESTAR.domain.Usuario;
import com.basis.darkzera.SISGESTAR.service.dto.ComentarioListDTO;
import com.basis.darkzera.SISGESTAR.service.dto.UsuarioDTO;
import com.basis.darkzera.SISGESTAR.service.dto.UsuarioListDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-21T19:02:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDTO.getId() );
        usuario.setName( usuarioDTO.getName() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setHash( usuarioDTO.getHash() );
        usuario.setComentarios( comentarioListDTOListToComentarioList( usuarioDTO.getComentarios() ) );

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setName( usuario.getName() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setHash( usuario.getHash() );
        usuarioDTO.setComentarios( comentarioListToComentarioListDTOList( usuario.getComentarios() ) );

        return usuarioDTO;
    }

    @Override
    public UsuarioListDTO toListDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioListDTO usuarioListDTO = new UsuarioListDTO();

        usuarioListDTO.setId( usuario.getId() );
        usuarioListDTO.setName( usuario.getName() );

        return usuarioListDTO;
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
}
