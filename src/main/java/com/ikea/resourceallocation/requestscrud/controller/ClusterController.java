package com.ikea.resourceallocation.requestscrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikea.resourceallocation.requestscrud.dto.ClustersDto;
import com.ikea.resourceallocation.requestscrud.model.Cluster;
import com.ikea.resourceallocation.requestscrud.service.ClusterService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/req/clus")
public class ClusterController {

	@Autowired
	private ClusterService clusterService;

	@GetMapping("/getAll")
	public ResponseEntity<List<ClustersDto>> getAllClusters(
			@RequestParam(value = "clustersOnly", required = false, defaultValue = "false") boolean clustersOnly) {
		System.out.println("Cluster Only: " + clustersOnly);
		List<ClustersDto> allClusters = clusterService.getAllClustersService(clustersOnly);
		return new ResponseEntity<>(allClusters, HttpStatus.OK);
	}
}
