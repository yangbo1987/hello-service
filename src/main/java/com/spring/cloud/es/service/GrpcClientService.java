//package com.spring.cloud.es.service;
//
//import java.util.logging.Level;
//
//import org.springframework.stereotype.Service;
//import com.ylifegroup.protobuf.PhoneServiceGrpc;
//import com.ylifegroup.protobuf.Phonebook.AddPhoneToUserRequest;
//import com.ylifegroup.protobuf.Phonebook.AddPhoneToUserResponse;
//import com.ylifegroup.protobuf.Phonebook.PhoneType;
//import io.grpc.Channel;
//import io.grpc.StatusRuntimeException;
//import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
//
//@Service
//public class GrpcClientService {
//	@GrpcClient("local-grpc-server")
//	private Channel channel;
//	
//	/** add phone to user. */
//	public void addPhoneToUser(int uid, PhoneType phoneType, String phoneNubmer) {
//		final PhoneServiceGrpc.PhoneServiceBlockingStub blockingStub = PhoneServiceGrpc.newBlockingStub(channel);
//		System.out.println("Will try to add phone to user " + uid);
//		AddPhoneToUserRequest request = AddPhoneToUserRequest.newBuilder()
//				.setUid(uid).setPhoneType(phoneType)
//				.setPhoneNumber(phoneNubmer).build();
//		AddPhoneToUserResponse response;
//		try {
//			response = blockingStub.addPhoneToUser(request);
//		} catch (StatusRuntimeException e) {
//			e.printStackTrace();
//			return;
//		}
//		System.out.println("Result: " + response.getResult());
//	}
//}
