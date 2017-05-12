/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.exception;

/**
 *
 * @author hallgato
 */
public class FacadeException extends Exception {

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}
}