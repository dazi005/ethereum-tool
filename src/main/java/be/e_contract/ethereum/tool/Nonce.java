/*
 * Ethereum Tool project.
 *
 * Copyright 2018 e-Contract.be BVBA. All rights reserved.
 * e-Contract.be BVBA proprietary/confidential. Use is subject to license terms.
 */
package be.e_contract.ethereum.tool;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import picocli.CommandLine;

@CommandLine.Command(name = "nonce", description = "retrieve the transaction nonce", separator = " ")
public class Nonce implements Callable<Void> {

    @CommandLine.Option(names = {"-l", "--location"}, required = true, description = "the location of the client node")
    private Web3j web3;

    @CommandLine.Option(names = {"-a", "--address"}, required = true, description = "the key address")
    private String address;

    @Override
    public Void call() throws Exception {
        BigInteger transactionCount = this.web3.ethGetTransactionCount(this.address, DefaultBlockParameterName.LATEST).send().getTransactionCount();
        System.out.println("transaction count: " + transactionCount);
        return null;
    }
}
