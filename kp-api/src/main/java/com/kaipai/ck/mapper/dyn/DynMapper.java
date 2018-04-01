/**
 * 
 */
package com.kaipai.ck.mapper.dyn;

import java.util.List;

import com.kaipai.ck.model.common.QueryModel;
import com.kaipai.ck.model.dyn.AppUserDynModel;
import com.kaipai.ck.model.dyn.DynPicModel;
import com.kaipai.ck.model.dyn.DynPriaiseModel;

/**
 * @author cloud
 *
 */
public interface DynMapper {
	AppUserDynModel createUserDyn(AppUserDynModel dynModel);
	List<AppUserDynModel> findPublicDynList(QueryModel model);
	List<AppUserDynModel> findUserDynList(QueryModel model);
	int deleteDynByUserId(AppUserDynModel model);
	int createLikeForDyn(DynPriaiseModel model);
	int deleteLikeForDyn(DynPriaiseModel model);
	int createDynPic(DynPicModel model);
	List<DynPicModel> findDynPicByMsgId(String msgId);
	int deleteDynPicByPicId(String picId);
	int deleteDynPicsByMsgId(String msgId);
}
