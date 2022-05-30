package com.pojo;

public class DataModel 
{
	private String sl_no;
	private String business_code;
	private String cust_number;
	private String clear_date;
	private String buisness_year;
	private String doc_id;
	private String posting_date;
	private String document_create_date;
	private String due_in_date;
	private String invoice_currency;
	private String document_type;
	private String posting_id;
	private String total_open_amount;
	private String baseline_create_date;
	private String cust_payment_terms;
	private String invoice_id;
	
	public DataModel(String sl_no, String business_code, String cust_number, String clear_date,String buisness_year,String doc_id,
			String posting_date, String document_create_date, String due_in_date,
			String invoice_currency, String document_type, String posting_id,
			String total_open_amount, String baseline_create_date, String cust_payment_terms, String invoice_id
			) {
     	super();
		this.sl_no = sl_no;
		this.business_code = business_code;
		this.cust_number = cust_number;
		this.buisness_year=buisness_year;
		this.clear_date = clear_date;
		this.doc_id = doc_id;
		this.posting_date = posting_date;
		this.document_create_date = document_create_date;
		this.due_in_date = due_in_date;
		this.invoice_currency = invoice_currency;
		this.document_type = document_type;
		this.posting_id = posting_id;
		this.total_open_amount = total_open_amount;
		this.baseline_create_date = baseline_create_date;
		this.cust_payment_terms = cust_payment_terms;
		this.invoice_id = invoice_id;
	}
	/**
	 * @return the sl_no
	 */
	public String getSl_no() {
		return sl_no;
	}
	/**
	 * @param sl_no the sl_no to set
	 */
	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}
	/**
	 * @return the business_code
	 */
	public String getBusiness_code() {
		return business_code;
	}
	/**
	 * @param business_code the business_code to set
	 */
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	/**
	 * @return the cust_number
	 */
	public String getCust_number() {
		return cust_number;
	}
	/**
	 * @param cust_number the cust_number to set
	 */
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	/**
	 * @return the clear_date
	 */
	public String getClear_date() {
		return clear_date;
	}
	/**
	 * @param clear_date the clear_date to set
	 */
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	/**
	 * @return the doc_id
	 */
	public String getDoc_id() {
		return doc_id;
	}
	/**
	 * @param doc_id the doc_id to set
	 */
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	/**
	 * @return the posting_date
	 */
	public String getPosting_date() {
		return posting_date;
	}
	/**
	 * @param posting_date the posting_date to set
	 */
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	/**
	 * @return the document_create_date
	 */
	public String getDocument_create_date() {
		return document_create_date;
	}
	/**
	 * @param document_create_date the document_create_date to set
	 */
	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}

	/**
	 * @return the due_in_date
	 */
	public String getDue_in_date() {
		return due_in_date;
	}
	/**
	 * @param due_in_date the due_in_date to set
	 */
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date;
	}
	/**
	 * @return the invoice_currency
	 */
	public String getInvoice_currency() {
		return invoice_currency;
	}
	/**
	 * @param invoice_currency the invoice_currency to set
	 */
	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}
	/**
	 * @return the document_type
	 */
	public String getDocument_type() {
		return document_type;
	}
	/**
	 * @param document_type the document_type to set
	 */
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	/**
	 * @return the posting_id
	 */
	public String getPosting_id() {
		return posting_id;
	}
	/**
	 * @param posting_id the posting_id to set
	 */
	public void setPosting_id(String posting_id) {
		this.posting_id = posting_id;
	}
	/**
	 * @return the total_open_amount
	 */
	public String getTotal_open_amount() {
		return total_open_amount;
	}
	/**
	 * @param total_open_amount the total_open_amount to set
	 */
	public void setTotal_open_amount(String total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	/**
	 * @return the baseline_create_date
	 */
	public String getBaseline_create_date() {
		return baseline_create_date;
	}
	/**
	 * @param baseline_create_date the baseline_create_date to set
	 */
	public void setBaseline_create_date(String baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}
	/**
	 * @return the cust_payment_terms
	 */
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	/**
	 * @param cust_payment_terms the cust_payment_terms to set
	 */
	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	/**
	 * @return the invoice_id
	 */
	public String getInvoice_id() {
		return invoice_id;
	}
	/**
	 * @param invoice_id the invoice_id to set
	 */
	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}
	/**
	 * @return the isOpen
	 */
	public String getBusiness_year() {
		return buisness_year;
	}
	public void setBusiness_year(String business_year) {
		this.buisness_year = buisness_year;
	}
}
