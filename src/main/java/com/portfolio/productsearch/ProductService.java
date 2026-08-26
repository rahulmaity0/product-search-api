package com.portfolio.productsearch;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;
    private final VectorStore vectorStore;

    public Product addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        
        // Generate an embedding for the product description and save it to the vector store
        Document doc = new Document(
            product.getDescription(), 
            Map.of("productId", savedProduct.getId(), "name", savedProduct.getName())
        );
        vectorStore.add(List.of(doc));
        
        return savedProduct;
    }

    public List<Document> searchProducts(String query) {
        // Perform a semantic similarity search
        return vectorStore.similaritySearch(SearchRequest.query(query).withTopK(5));
    }
}
