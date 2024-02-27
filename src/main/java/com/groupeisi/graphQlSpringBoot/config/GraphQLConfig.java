package com.groupeisi.graphQlSpringBoot.config;

import com.groupeisi.graphQlSpringBoot.resolver.StudentResolver;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Bean
    public GraphQLSchema graphQLSchema() throws IOException {
        String schemaFilePath = "schema.graphqls";
        String schema = loadSchemaFromFile(schemaFilePath);

        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schema);
        RuntimeWiring wiring = buildWiring();
        return new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
    }

    private String loadSchemaFromFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    private RuntimeWiring buildWiring() {
        StudentResolver studentResolver = new StudentResolver();

        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("getAllStudents", environment -> studentResolver.getAllStudents())
                        .dataFetcher("countStudents", environment -> studentResolver.countStudents()))
                .type("Mutation", typeWiring -> typeWiring
                        .dataFetcher("addStudent", environment -> studentResolver.addStudent(environment.getArgument("student"))))
                .build();
    }
}
