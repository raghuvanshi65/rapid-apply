package com.example.rapidapply.services;

import com.example.rapidapply.commons.SkillsMapper;
import com.example.rapidapply.entity.PublicProfile;
import com.example.rapidapply.entity.Skills;
import com.example.rapidapply.models.User;
import com.example.rapidapply.repository.SkillsRepository;
import com.example.rapidapply.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillsService {
    private static Logger LOGGER = LoggerFactory.getLogger(SkillsService.class);

    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private UserRepository userRepository;

    public User updateSkills(User userModel){
        try {
            com.example.rapidapply.entity.User userEntity = userRepository.getUserByEmail(userModel.getEmail());
            List<Skills> skillsList = userEntity.getSkillsList();
            List<com.example.rapidapply.models.Skills> skillsModelList = userModel.getSkillsList();

            for(com.example.rapidapply.models.Skills skillsModel : skillsModelList){
                Skills skills = SkillsMapper.modelToEntity(skillsModel);
                skills.setUser(userEntity);
                skillsList.removeIf(i->i.getSkillType().equals(skillsModel.getSkillType()));
                skillsList.add(skills);
            }

            userEntity.setSkillsList(skillsList);
            userRepository.save(userEntity);

            LOGGER.info("skills have been successfully updated");
            return userModel;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while updateSkills in SkillsService class",exception);
            return null;
        }
    }

    public Boolean deleteSkill(String skillId){
        try {
            skillsRepository.deleteById(skillId);
            LOGGER.info("The skill is successfully deleted");
            return true;
        }catch (Exception exception){
            LOGGER.error("An exception occurred while deleteSkill in SkillsService class",exception);
            return false;
        }
    }


}
