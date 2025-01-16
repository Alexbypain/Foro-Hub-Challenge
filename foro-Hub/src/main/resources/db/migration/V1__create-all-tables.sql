create table perfiles(
    `perfil_id` bigint not null auto_increment,
    `nombre` varchar(100) not null,
    PRIMARY KEY (`perfil_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table usuarios(
    `usuario_id` bigint not null auto_increment,
    `nombre` varchar(100) not null,
    `email` varchar(255) not null,
    `password` varchar(255) not null,
    PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table usuarios_perfil(
   `usuario_id` bigint not null,
   `perfil_id` bigint not null,
   FOREIGN KEY (`usuario_id`) REFERENCES usuarios(`usuario_id`),
   FOREIGN KEY (`perfil_id`) REFERENCES perfiles(`perfil_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table cursos(
    `curso_id` bigint not null auto_increment,
    `nombre` varchar(100) not null,
    `categoria` varchar(100) not null,
    PRIMARY KEY (`curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table topicos(
                        `topico_id` bigint not null auto_increment,
                        `titulo` varchar(255) not null,
                        `mensaje` varchar(255) not null,
                        `fecha_creacion` date not null,
                        `status` varchar(100) not null,
                        `usuario_id` bigint not null,
                        `curso_id` bigint not null,
                        PRIMARY KEY (`topico_id`),
                        FOREIGN KEY (`usuario_id`) REFERENCES usuarios(`usuario_id`),
                        FOREIGN KEY (`curso_id`) REFERENCES cursos(`curso_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




create table respuestas(
    `respuesta_id` bigint not null auto_increment,
    `mensaje` varchar(255) not null,
    `usuario_id` bigint not null,
    `fecha_creacion` date not null,
    `solucion` tinyint not null,
    `topico_id` BIGINT DEFAULT NULL,
    PRIMARY KEY (`respuesta_id`),
    FOREIGN KEY (`usuario_id`) REFERENCES usuarios(`usuario_id`),
    FOREIGN KEY (`topico_id`) REFERENCES topicos(`topico_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

