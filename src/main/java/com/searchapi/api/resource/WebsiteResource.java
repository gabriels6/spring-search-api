package com.searchapi.api.resource;

import com.searchapi.api.model.Website_Data;
import com.searchapi.api.request.body.WebsiteDataBody;
import com.searchapi.api.service.CategoryService;
import com.searchapi.api.service.WebsiteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/website")
public class WebsiteResource {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private WebsiteDataService websiteDataService;

    @GetMapping("/")
    public List<Website_Data> index(){
        return websiteDataService.getAllWebsiteDatas();
    }

    @GetMapping("/{id}")
    public Website_Data index(@PathVariable(value = "id") int websiteDataId){
        return websiteDataService.getWebsiteDataById(websiteDataId);
    }

    @PostMapping("/")
    public Website_Data store(@Valid @RequestBody WebsiteDataBody websiteDataBody){
        return websiteDataService.insertWebsiteData(websiteDataBody);
    }

    @PutMapping("/{id}/category/{categoryId}")
    public ResponseEntity<Website_Data> update(@Valid @RequestBody WebsiteDataBody website_data, @PathVariable(value = "id") int websiteDataId, @PathVariable(value="categoryId") int categoryId){
        return websiteDataService.updateWebsiteData(website_data,websiteDataId);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> delete(@PathVariable(value = "id") int websiteDataId){
        return websiteDataService.deleteWebsiteData(websiteDataId);
    }


}
