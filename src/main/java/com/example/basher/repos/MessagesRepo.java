package com.example.basher.repos;

import com.example.basher.domain.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepo extends CrudRepository<Messages, Long>{
}
