package com.mx.cji.crm.util.paginador;

import java.util.List;

import com.mx.cji.util.paginador.render.Bootstrap;
import com.mx.cji.util.paginador.render.PagerRender;
import com.mx.cji.util.paginador.render.Standard;



public abstract class Page {
	
	final private String defaultAdapter = "Standard";
	
	public List<Object> results;

	private int page;

	private int resultsPerPage;

	private int totalCount;

	private String queryString;

	public List<Object> getResults() {
		return results;
	}

	public void setResults(List<Object> results) {
		this.results = results;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
	public PagerRender getRender() {
		return getRender(defaultAdapter);
	}

	public PagerRender getRender(String adapterName) {
		if (null == adapterName){
			adapterName = defaultAdapter;
		}

		if (adapterName.length() == 0) {
			throw new NullPointerException("Adapter name must be specified in a string.");
		}
		
		if(adapterName.equals(defaultAdapter)){
			return new Standard(page, totalCount, resultsPerPage);
		}
		if(adapterName.equals("Bootstrap")){
			return new Bootstrap(page, totalCount, resultsPerPage);
		}
		return new Standard(page, totalCount, resultsPerPage);
	}
}
