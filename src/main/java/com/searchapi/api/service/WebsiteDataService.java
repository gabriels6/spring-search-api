package com.searchapi.api.service;

import com.searchapi.api.model.Category;
import com.searchapi.api.model.Website_Data;
import com.searchapi.api.repository.CategoryRepository;
import com.searchapi.api.repository.WebsiteDataRepository;
import com.searchapi.api.request.body.WebsiteDataBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebsiteDataService {

    @Autowired
    private WebsiteDataRepository websiteDataRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Website_Data> getAllWebsiteDatas(){
        return websiteDataRepository.findAll();
    }

    public Website_Data getWebsiteDataById(int websiteDataId){
        return websiteDataRepository.findById(websiteDataId).orElseThrow(() -> new ResourceNotFoundException("Website not found with given id!"));
    }

    public Website_Data insertWebsiteData(WebsiteDataBody websiteDataBody){

        Website_Data websiteData = new Website_Data();

        Category category = categoryRepository.findById(websiteDataBody.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found with given id!"));

        websiteData.setLink(websiteDataBody.getLink());
        websiteData.setTitle(websiteDataBody.getTitle());
        websiteData.setDescription(websiteDataBody.getDescription());
        websiteData.setCategory(category);

        return websiteDataRepository.save(websiteData);
    }

    public ResponseEntity<Website_Data> updateWebsiteData(WebsiteDataBody websiteDataDetails, int websiteDataId){

        Category category = categoryRepository
                .findById(websiteDataDetails.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with given id!"));

        Website_Data currentWebsitedata = websiteDataRepository
                .findById(websiteDataId)
                .orElseThrow(() -> new ResourceNotFoundException("Website not found with given id!"));


        currentWebsitedata.setWebsiteData(category,websiteDataDetails.getLink(),websiteDataDetails.getTitle(),websiteDataDetails.getDescription());

        Website_Data updatedWebsiteData = websiteDataRepository.save(currentWebsitedata);

        return ResponseEntity.ok(updatedWebsiteData);
    }

    public Map<String, Boolean> deleteWebsiteData(int websiteDataId){

        Website_Data websiteData = websiteDataRepository
                .findById(websiteDataId)
                .orElseThrow(() -> new ResourceNotFoundException("WebsiteData not found with given Id!"));

        websiteDataRepository.delete(websiteData);

        HashMap<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }

}
