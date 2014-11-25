package com.upcera.ddx.action;

import java.util.HashMap;
import java.util.Map;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.entity.LabProceduresPrice;

public class Test {
	static String jsson = "[{\"price\":\"1\",\"attr\":[{\"id\":\"getAlloy_material_presence\",\"value\":\"A-M-23,A-M-25\"},{\"id\":\"getCoping_presence\",\"value\":\"C-M\"}],\"group\":\"999\"},{\"price\":\"2\",\"attr\":[{\"id\":\"getPontic_contours_presence\",\"value\":\"P-C-MRL,P-C-H\"},{\"id\":\"getMargin_presence\",\"value\":\"M-PDM,M-FMLB\"}],\"group\":\"998\"},{\"price\":\"3\",\"attr\":[{\"id\":\"getOcclusal_contact_presence\",\"value\":\"O-C-PC,O-C-FR\"},{\"id\":\"getInsufficient_room_presence\",\"value\":\"I-R-AO,I-R-RC\"}],\"group\":\"999\"}]";
	public static void main(String[] args) {
		testAddProPriceAttrJson();
	}
	public static void testAddProPriceAttrJson(){
		try {
			Map[] map = ToolsKit.jsonUitl.toBean(Map[].class, jsson);
			for (int i = 0; i < map.length; i++) {
				System.out.println(map[i].get("price"));
				System.out.println(map[i].get("attr"));
				System.out.println(map[i].get("group"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testProPriceAttrJson(){

		LabProceduresPrice.PriceAttributes priceAttributes = new LabProceduresPrice.PriceAttributes();
		 Map<String, Object> teeth = new HashMap<String, Object>();
		 teeth.put("1", "a");
		 Map<String, Object> alloyMaterial = new HashMap<String, Object>();
		 alloyMaterial.put("1", "a");
		 Map<String, Object> coping = new HashMap<String, Object>();
		 coping.put("1", "a");
		 Map<String, Object> ponticContours = new HashMap<String, Object>();
		 ponticContours.put("1", "a");
		 Map<String, Object> margin = new HashMap<String, Object>();
		 margin.put("1", "a");
		 Map<String, Object> rpd = new HashMap<String, Object>();
		 rpd.put("1", "a");
		 Map<String, Object> contactsEmbrasures = new HashMap<String, Object>();
		 contactsEmbrasures.put("1", "a");
		 Map<String, Object> occlusalContact = new HashMap<String, Object>();
		 occlusalContact.put("1", "a");
		 Map<String, Object> insufficientRoom = new HashMap<String, Object>();
		 insufficientRoom.put("1", "a");
		 Map<String, Object> retention = new HashMap<String, Object>();
		 retention.put("1", "a");
		 Map<String, Object> marginPosition = new HashMap<String, Object>();
		 marginPosition.put("1", "a");
		 Map<String, Object> emergenceWidth = new HashMap<String, Object>();
		 emergenceWidth.put("1", "a");
		 Map<String, Object> staining = new HashMap<String, Object>();
		 staining.put("1", "a");
		 Map<String, Object> stainPlacement = new HashMap<String, Object>();
		 stainPlacement.put("1", "a");
		 Map<String, Object> surfaceTexture = new HashMap<String, Object>();
		 surfaceTexture.put("1", "a");
		 Map<String, Object> surfaceFinish = new HashMap<String, Object>();
		 surfaceFinish.put("1", "a");
		 Map<String, Object> translucencyShade = new HashMap<String, Object>();
		 translucencyShade.put("1", "a");
		 Map<String, Object> translucencyVolume = new HashMap<String, Object>();
		 translucencyVolume.put("1", "a");
		 
		 priceAttributes.setTeeth(teeth);
		 priceAttributes.setAlloyMaterial(alloyMaterial);
		 priceAttributes.setCoping(coping);
		 priceAttributes.setPonticContours(ponticContours);
		 priceAttributes.setMargin(margin);
		 priceAttributes.setRpd(rpd);
		 priceAttributes.setContactsEmbrasures(contactsEmbrasures);
		 priceAttributes.setOcclusalContact(occlusalContact);
		 priceAttributes.setInsufficientRoom(insufficientRoom);
		 priceAttributes.setRetention(retention);
		 priceAttributes.setMarginPosition(marginPosition);
		 priceAttributes.setEmergenceWidth(emergenceWidth);
		 priceAttributes.setStaining(staining);
		 priceAttributes.setStainPlacement(stainPlacement);
		 priceAttributes.setSurfaceTexture(surfaceTexture);
		 priceAttributes.setSurfaceFinish(surfaceFinish);
		 priceAttributes.setTranslucencyShade(translucencyShade);
		 priceAttributes.setTranslucencyVolume(translucencyVolume);
		 
		 try {
			 String json = ToolsKit.jsonUitl.toJson(priceAttributes);
			System.out.println(json);
			LabProceduresPrice.PriceAttributes pri = ToolsKit.jsonUitl.toBean(LabProceduresPrice.PriceAttributes.class, json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	
	}
	
}
